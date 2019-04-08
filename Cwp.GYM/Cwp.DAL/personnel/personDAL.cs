﻿using Cwp.DAL.CURD;
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
            person model = new person();
            model.accountnumber = account;
            person p = new curdHelp().SelectData<person>(model);
            return p.password;
        }
    }
}
