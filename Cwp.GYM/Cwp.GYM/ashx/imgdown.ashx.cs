using Cwp.BLL;
using Cwp.Model;
using System;
using System.Collections.Generic;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Text;
using System.Web;
using System.Web.Script.Serialization;

namespace Cwp.GYM.ashx
{
    /// <summary>
    /// imgdown 的摘要说明
    /// </summary>
    public class imgdown : IHttpHandler
    {

        public void ProcessRequest(HttpContext context)
        {
            var code = context.Request["code"];
            List<picturepath> picturepaths = new picturepathBLL().getALLPicturePathList(code);
            List<string> base64list = new List<string>();
            StringBuilder sb = new StringBuilder();
            foreach (picturepath p in picturepaths)
            {
                try
                {
                    FileStream fs = File.OpenRead(p.path);
                    int fileLength = 0;
                    fileLength=(int)fs.Length;
                    Byte[] image = new Byte[fileLength];
                    fs.Read(image,0,fileLength);
                    string strbase64 = Convert.ToBase64String(image);
                    base64list.Add(strbase64);
                }
                catch
                {

                }
            }
            JavaScriptSerializer jss = new JavaScriptSerializer();
            jss.Serialize(base64list, sb);
            context.Response.Write(sb.ToString());
        }

        public bool IsReusable
        {
            get
            {
                return false;
            }
        }
    }
}