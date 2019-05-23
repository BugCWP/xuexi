using Cwp.Model;
using Cwp.Model.personnel;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Cwp.BLL.person
{
    public class staffBLL : EntityBLL<staff>
    {
        /// <summary>
        /// 获取列表页信息和图片信息
        /// </summary>
        /// <typeparam name="T"></typeparam>
        /// <returns></returns>
        public dataList<staffAndImg> GetDataListAndImg(string pageIndex, string pageSize, string search, string paramList)
        {
            dataList<staff> dataList = new EntityBLL<staff>().GetDataList<staff>(pageIndex, pageSize, search, paramList);
            dataList<staffAndImg> staffAndImgList = new dataList<staffAndImg>();
            staffAndImgList.list = new List<staffAndImg>();
            foreach (staff s in dataList.list)
            {
                staffAndImg staffAndImg = new staffAndImg();
                staffAndImg.staff = s;
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
                staffAndImgList.list.Add(staffAndImg);
            }
            staffAndImgList.pageCount = dataList.pageCount;
            staffAndImgList.Count = dataList.Count;
            return staffAndImgList;
        }
    }
}
