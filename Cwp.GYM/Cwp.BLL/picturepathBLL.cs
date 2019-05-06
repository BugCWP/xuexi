using Cwp.DAL.CURD;
using Cwp.Model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Cwp.BLL
{
    public class picturepathBLL:EntityBLL<picturepath>
    {
        //更具code获取图片信息
        public List<picturepath> getALLPicturePathList(string code)
        {
            picturepath pp = new picturepath();
            pp.code = new Guid(code);
            return new curdHelp().SelectDataList<picturepath>(pp);
        }
    }
}
