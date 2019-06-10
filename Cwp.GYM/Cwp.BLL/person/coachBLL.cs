using Cwp.DAL.CURD;
using Cwp.Model.personnel;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Cwp.BLL.person
{
    public class coachBLL:EntityBLL<coach>
    {
        public string coachRegister(coach coach)
        {
            //检查用户名是否重复
            coach c1 = new coach();
            c1.accountnumber = coach.accountnumber;
            List<coach> c1list = new curdHelp().SelectDataList<coach>(c1);
            if (c1list.Count > 0)
            {
                return "用户名已存在";
            }
            else
            {
                return Convert.ToInt32(new customerBLL().CreateData<coach>(coach)) > 0 ? "success" : "新增失败";
            }
        }
    }
}
