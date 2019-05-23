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
    public class equipmentBLL : EntityBLL<equipment>
    {
        /// <summary>
        /// 获取列表页信息和图片信息
        /// </summary>
        /// <typeparam name="T"></typeparam>
        /// <returns></returns>
        public dataList<equipmentAndImg> GetDataListAndImg(string pageIndex, string pageSize, string search, string paramList)
        {
            dataList<equipment> dataList = new EntityBLL<equipment>().GetDataList<equipment>(pageIndex, pageSize, search, paramList);
            dataList<equipmentAndImg> equipmentAndImgList = new dataList<equipmentAndImg>();
            equipmentAndImgList.list = new List<equipmentAndImg>();
            foreach (equipment s in dataList.list)
            {
                equipmentAndImg staffAndImg = new equipmentAndImg();
                staffAndImg.equipment = s;
                if (s.code.ToString() != null && s.code.ToString() != "")
                {
                    List<picturepath> picturepaths = new picturepathBLL().getALLPicturePathList(s.code.ToString());
                    staffAndImg.imgList = new List<string>();
                    foreach (picturepath p in picturepaths)
                    {
                        FileStream fs = File.OpenRead(p.path);
                        int fileLength = 0;
                        fileLength = (int)fs.Length;
                        Byte[] image = new Byte[fileLength];
                        fs.Read(image, 0, fileLength);
                        string strbase64 = Convert.ToBase64String(image);
                        staffAndImg.imgList.Add(strbase64);
                    }
                }
                equipmentAndImgList.list.Add(staffAndImg);
            }
            equipmentAndImgList.pageCount = dataList.pageCount;
            equipmentAndImgList.Count = dataList.Count;
            return equipmentAndImgList;
        }
    }
}
