﻿using Cwp.DAL.personnel;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Cwp.BLL.person
{
    public class personBLL
    {
        /// <summary>
        /// 人员登陆
        /// </summary>
        /// <returns></returns>
        public string personLogin(string account,string password)
        {
            string passwordSQL = new personDAL().SelectPassword(account);
            string result = "";
            if (passwordSQL==password)
            {
                result = "success";
            }
            return result;
        }


        /// <summary>
        /// 用户登陆
        /// </summary>
        /// <returns></returns>
        public string customerLogin(string account, string password)
        {
            string passwordSQL = new personDAL().SelectCustomerPassword(account);
            string result = "";
            if (passwordSQL == password)
            {
                result = "success";
            }
            return result;
        }

        /// <summary>
        /// 人员登陆
        /// </summary>
        /// <returns></returns>
        public string coachLogin(string account, string password)
        {
            string passwordSQL = new personDAL().SelectCoachPassword(account);
            string result = "";
            if (passwordSQL == password)
            {
                result = "success";
            }
            return result;
        }
    }
}
