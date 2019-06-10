using Cwp.DAL.CURD;
using Cwp.Model.personnel;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Cwp.DAL.personnel
{
   public class personDAL
    {
        /// <summary>
        /// 根据用户名搜索密码
        /// </summary>
        /// <param name=""></param>
        /// <returns></returns>
        public string SelectPassword(string account)
        {
            staff model = new staff();
            model.accountnumber = account;
            staff p = new curdHelp().SelectData<staff>(model);
            if (p != null)
            {
                return p.password;
            }
            else
            {
                return null;
            }
        }
        /// <summary>
        /// 用户根据用户名搜索密码
        /// </summary>
        /// <param name=""></param>
        /// <returns></returns>
        public string SelectCustomerPassword(string account)
        {
            customer model = new customer();
            model.accountnumber = account;
            customer p = new curdHelp().SelectData<customer>(model);
            if (p != null)
            {
                return p.password;
            }
            else
            {
                return null;
            }
        }
        /// <summary>
        /// 教练根据用户名搜索密码
        /// </summary>
        /// <param name=""></param>
        /// <returns></returns>
        public string SelectCoachPassword(string account)
        {
            coach model = new coach();
            model.accountnumber = account;
            coach p = new curdHelp().SelectData<coach>(model);
            if (p != null)
            {
                return p.password;
            }
            else
            {
                return null;
            }
        }
    }
}
