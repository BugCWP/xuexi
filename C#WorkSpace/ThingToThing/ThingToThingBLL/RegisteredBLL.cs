using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using ThingToThingDAL;
using ThingToThingModel;

namespace ThingToThingBLL
{
    public class RegisteredBLL
    {
        RegisteredDAL rd = new RegisteredDAL();
        public List<ProvinceModel> SelectProvinceBLL()
        {
            return rd.SelectProvinceDAL();
        }
        public List<ProvinceModel> SelectCityBLL(string province)
        {
            return rd.SelectCityDAL(province);
        }

        public bool ConfimUserId(string Id)
        {
            int res=rd.ConfimUserId(Id);
            if (res > 0)
            {
                return false;
            }
            else
            {
                return true;
            }
        }

        public bool AddUserInfo(UserInfoModel u)
        {
            int res=rd.AddUserInfo(u);
            if (res > 0)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        public bool ConfimUserPwd(string id,out string pwd)
        {
           pwd=rd.ConfimUserPwd(id);
            if (pwd != "")
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        public UserInfoModel SelectUserInfo(string id)
        {
            return rd.SelectUserInfo(id);
        }
        public bool ChangeUserInfo(UserInfoModel u)
        {
            if (rd.ChangeUserInfo(u) > 0)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
    }
}
