using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data;
using System.Data.SqlClient;
using ThingToThingModel;

namespace ThingToThingDAL
{
    public class RegisteredDAL
    {
        #region 查询省
        public List<ProvinceModel> SelectProvinceDAL()
        {
            string sql = "select distinct AdressProvince from AdressInfo";
            DataTable dt= sqlHelp.getDatable(sql);
            List<ProvinceModel> listpm = new List<ProvinceModel>();
            if (dt.Rows.Count > 0)
            {
                foreach(DataRow dr in dt.Rows)
                {
                    ProvinceModel pm = new ProvinceModel();
                    pm.province = dr[0].ToString();
                    listpm.Add(pm);
                }
            }
            return listpm;
        }
        #endregion

        #region 查询市
        public List<ProvinceModel> SelectCityDAL(string province)
        {
            string sql = "select AdressCity from AdressInfo where AdressProvince=@province";
            SqlParameter[] ps =
            {
                new SqlParameter ("@province",province)
            };
            List<ProvinceModel> listpm = new List<ProvinceModel>();
            DataTable dt = sqlHelp.getDatable(sql, ps);
            if (dt.Rows.Count > 0)
            {
                foreach(DataRow dr in dt.Rows)
                {
                    ProvinceModel pm = new ProvinceModel();
                    pm.city = dr[0].ToString();
                    listpm.Add(pm);
                }
            }
            return listpm;
        }
        #endregion

        #region 查询用户Id是否存在
        public int ConfimUserId(string Id)
        {
            string sql = "select count(*) from UserInfo where UserLoginId=@Id and UserDelect=1";
            SqlParameter[] ps =
            {
                new SqlParameter ("@Id",Id),
            };
            int res=(int)sqlHelp.ExecuteScalar(sql, ps);
            return res;
        }
        #endregion

        #region 插入用户注册信息
        public int AddUserInfo(UserInfoModel u)
        {
            string sql = "insert into UserInfo (UserLoginId,UserName,UserPassWord,UserEmail,UserPhone,UserAdress,UserDelect) values(@id,@name,@pwd,@email,@phone,@adress,1)";
            SqlParameter[] ps =
            {
                new SqlParameter ("@id",u.UserLoginId),
                new SqlParameter("@name",u.UserName),
                new SqlParameter ("@pwd",u.UserPwd),
                new SqlParameter("@email",u.UserEmail),
                new SqlParameter("@phone",u.UserPhone),
                new SqlParameter("@adress",u.UserAdress)
            };
            int res = sqlHelp.ExecuteNonQuery(sql, ps);
            return res;
        }
        #endregion

        #region 查询密码是否正确
        public string ConfimUserPwd(string Id)
        {
            string sql = "select UserPassWord from UserInfo where UserLoginId=@Id";
            SqlParameter[] ps =
            {
                new SqlParameter ("@Id",Id),
            };
            string pwd =(string) sqlHelp.ExecuteScalar(sql, ps);
            return pwd;
        }
        #endregion

        #region 查询用户所有信息
        public UserInfoModel SelectUserInfo(string id)
        {
            string sql = "select * from UserInfo where UserLoginId=@id and UserDelect=1";
            SqlParameter[] ps =
           {
                new SqlParameter ("@Id",id),
            };
            DataTable dt = sqlHelp.getDatable(sql, ps);
            UserInfoModel ui = new UserInfoModel();
            if (dt.Rows.Count > 0)
            {
                DataRow dr = dt.Rows[0];
                ui.UserLoginId = dr[1].ToString();
                ui.UserName = dr[2].ToString();
                ui.UserPwd = dr[3].ToString();
                ui.UserEmail = dr[4].ToString();
                ui.UserPhone = dr[5].ToString();
                ui.UserAdress = dr[6].ToString();
            }
            return ui;
        }
        #endregion

        #region 修改用户信息
        public int ChangeUserInfo(UserInfoModel u)
        {
            string sql = "update UserInfo set UserName=@name,UserPassWord=@pwd,UserEmail=@email,UserPhone=@phone,UserAdress=@adress where UserLoginId=@id";
            SqlParameter[] ps =
            {
                new SqlParameter("@name",u.UserName),
                new SqlParameter("@id",u.UserLoginId),
                new SqlParameter ("@pwd",u.UserPwd),
                new SqlParameter("@email",u.UserEmail),
                new SqlParameter("@phone",u.UserPhone),
                new SqlParameter("@adress",u.UserAdress)
            };
            return sqlHelp.ExecuteNonQuery(sql, ps);
        }
        #endregion
    }
}
