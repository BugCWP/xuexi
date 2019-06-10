using Cwp.Common.SQLCommon;
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
    public class gymBLL:EntityBLL<gymroom>
    {
        /// <summary>
        /// 获取列表页信息和图片信息
        /// </summary>
        /// <typeparam name="T"></typeparam>
        /// <returns></returns>
        public dataList<gymAndImg> GetDataListAndImg(string search, string paramList)
        {
            List<gymroom> dataList = new EntityBLL<gymroom>().GetDataList<gymroom>(paramList);
            dataList<gymAndImg> gymAndImgList = new dataList<gymAndImg>();
            gymAndImgList.list = new List<gymAndImg>();
            foreach (gymroom s in dataList)
            {
                gymAndImg gymAndImg = new gymAndImg();
                gymAndImg.gym = s;
                if (s.code.ToString() != null && s.code.ToString() != "")
                {
                    List<picturepath> picturepaths = new picturepathBLL().getALLPicturePathList(s.code.ToString());
                    gymAndImg.imgList = new List<string>();
                    foreach (picturepath p in picturepaths)
                    {
                        FileStream fs = File.OpenRead(p.path);
                        int fileLength = 0;
                        fileLength = (int)fs.Length;
                        Byte[] image = new Byte[fileLength];
                        fs.Read(image, 0, fileLength);
                        string strbase64 = Convert.ToBase64String(image);
                        gymAndImg.imgList.Add(strbase64);
                    }
                }
                gymAndImgList.list.Add(gymAndImg);
            }
            return gymAndImgList;
        }
    }
}
