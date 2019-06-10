using Cwp.DAL.CURD;
using Cwp.Model.personnel;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Cwp.BLL.person
{
    public class customerBLL : EntityBLL<customer>
    {
        public string customerRegister(customer customer)
        {
            //检查用户名是否重复
            customer c1 = new customer();
            c1.accountnumber = customer.accountnumber;
            List<customer> c1list = new curdHelp().SelectDataList<customer>(c1);
            if (c1list.Count>0)
            {
                return "用户名已存在";
            }
            else
            {
              return  Convert.ToInt32(new customerBLL().CreateData<customer>(customer))>0?"success":"新增失败";
            }
        }
    }
}
