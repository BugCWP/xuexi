using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Cwp.Common.CodeCommon
{
    public class UtilCommon
    {
        /// <summary>
        /// MD5码转换
        /// </summary>
        /// <param name="text"></param>
        /// <returns></returns>
        public string MD5(string text)
        {
            byte[] buffer = System.Text.Encoding.Default.GetBytes(text);
            try
            {
                System.Security.Cryptography.MD5CryptoServiceProvider check;
                check = new System.Security.Cryptography.MD5CryptoServiceProvider();
                byte[] somme = check.ComputeHash(buffer);
                string ret = "";
                foreach (byte a in somme)
                {
                    if (a < 16)
                        ret += "0" + a.ToString("X");
                    else
                        ret += a.ToString("X");
                }
                return ret.ToLower();
            }
            catch
            {
                throw;
            }
        }
    }
}
