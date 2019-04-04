using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.IO;
using System.Security.Cryptography;

namespace ThingToThingCommon
{
   public  class MyTool
    {

        #region GetMD5拿一个流的MD5值  
        public  string GetMD5(Stream stream)
        {
            string result = string.Empty;
            MD5CryptoServiceProvider md5 = new MD5CryptoServiceProvider();
            byte[] bytes = md5.ComputeHash(stream);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.Length; i++)
            {
                sb.Append(bytes[i].ToString("X2"));
            }
            result = sb.ToString();
            return result;
        }
        #endregion

        #region CreateDirectory先去判断一个文件夹存不存在，如果不存在的话新建它  
        public  void CreateDirectory(string path)
        {
            if (!Directory.Exists(path))
            {
                Directory.CreateDirectory(path);
            }
        }
        #endregion
    }
}
