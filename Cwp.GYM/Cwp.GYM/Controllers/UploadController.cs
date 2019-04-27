using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Threading.Tasks;
using System.Web;
using System.Web.Http;

namespace Cwp.GYM.Controllers
{
    public class UploadController : ApiController
    {
        [HttpPost]
        [Route("api/Upload/ImgUpload")]
        public Task<Hashtable> ImgUpload()
        {
            //检查是否是 multipart/form-data
            if (!Request.Content.IsMimeMultipartContent("form-data"))
            {
                throw new HttpResponseException(HttpStatusCode.UnsupportedMediaType);
            }

            //文件保存目录
            const string saveTempPath = "~/UploadFiles/";
            var dirTempPath = HttpContext.Current.Server.MapPath(saveTempPath);


        }
    }
}