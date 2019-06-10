using Cwp.DAL.CURD;
using Cwp.Model;
using Cwp.Model.gym;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Cwp.BLL.gym
{
    public class gym_equipmentBLL : EntityBLL<gym_equipment>
    {
        /// <summary>
        /// 获取列表页信息和图片信息
        /// </summary>
        /// <typeparam name="T"></typeparam>
        /// <returns></returns>
        public dataList<gym_equipmentAndImg> GetDataListAndImg(string pageIndex, string pageSize, string search, string paramList)
        {
            dataList<gym_equipment> dataList = new EntityBLL<gym_equipment>().GetDataList<gym_equipment>(pageIndex, pageSize, search, paramList);
            dataList<gym_equipmentAndImg> gymEquipmentAndImgList = new dataList<gym_equipmentAndImg>();
            gymEquipmentAndImgList.list = new List<gym_equipmentAndImg>(); 
            foreach (gym_equipment ge in dataList.list)
            {
                equipment e = new EntityBLL<equipment>().GetData<equipment>(ge.equipmentid.ToString());
                gym_equipmentAndImg gym_EquipmentAndImg = new gym_equipmentAndImg();
                gym_EquipmentAndImg.gym_equipment = ge;
                if (e.code.ToString() != null && e.code.ToString() != "")
                {
                    List<picturepath> picturepaths = new picturepathBLL().getALLPicturePathList(e.code.ToString());
                    gym_EquipmentAndImg.imgList = new List<string>();
                    foreach (picturepath p in picturepaths)
                    {
                        FileStream fs = File.OpenRead(p.path);
                        int fileLength = 0;
                        fileLength = (int)fs.Length;
                        Byte[] image = new Byte[fileLength];
                        fs.Read(image, 0, fileLength);
                        string strbase64 = Convert.ToBase64String(image);
                        gym_EquipmentAndImg.imgList.Add(strbase64);
                    }
                }
                gymEquipmentAndImgList.list.Add(gym_EquipmentAndImg);
            }
            gymEquipmentAndImgList.pageCount = dataList.pageCount;
            gymEquipmentAndImgList.Count = dataList.Count;
            return gymEquipmentAndImgList;
        }

        public string Bugequipment(string equipmentid, string gymid, string number)
        {
            gym_equipment ge = new gym_equipment();
            ge.equipmentid = new Guid(equipmentid);
            ge.gymroomid = new Guid(gymid);
            List<gym_equipment> gelist= new curdHelp().SelectDataList<gym_equipment>(ge);
            if (gelist.Count>0)
            {
                gym_equipment ge1 = new gym_equipmentBLL().GetData<gym_equipment>(ge);
                ge1.amount = (Convert.ToInt32(ge1.amount) + Convert.ToInt32(number)).ToString();
                return new gym_equipmentBLL().UpdateData<gym_equipment>(ge1);
            }
            else
            {
                gym_equipment ge2 = new gym_equipment();
                ge2.gymroomid = new Guid(gymid);
                gymroom gymroom = new gymroom();
                gymroom.id = new Guid(gymid);
                ge2.gymroomname = new gymBLL().GetData<gymroom>(gymroom).name;
                ge2.equipmentid = new Guid(equipmentid);
                equipment equipment = new equipment();
                equipment.id = new Guid(equipmentid);
                ge2.equipmentname = new equipmentBLL().GetData<equipment>(equipment).name;
                ge2.amount = number;
                ge2.purchasetime = new DateTime().ToString();
                return new gym_equipmentBLL().CreateData<gym_equipment>(ge2);
            }
        }
    }
}
