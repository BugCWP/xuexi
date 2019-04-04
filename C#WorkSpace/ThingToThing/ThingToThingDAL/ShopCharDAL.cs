using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using ThingToThingModel;
using System.Data;
using System.Data.SqlClient;

namespace ThingToThingDAL
{
    public class ShopCharDAL
    {
        #region 添加购物车物品交换
        public int ShopCharThingAdd(string myid,string changeid,string UserId,string HUserId)
        {
            string sql = "insert into ShopCharInfo (SThingId,SHThingId,SUserId,SHUserId,SDelect) values (@myid,@Changeid,@Userid,@HUserid,1)";
            SqlParameter[] ps =
            {
                new SqlParameter ("@myid",myid),
                new SqlParameter ("@Changeid",changeid),
                new SqlParameter("@Userid",UserId),
                new SqlParameter("@HUserid",HUserId)
            };
            return sqlHelp.ExecuteNonQuery(sql, ps);
        }
        #endregion

        #region 查询购物车未同意交换物品
        public List<ShopCharModel> selectShopChar(string uid)
        {
            string sql = "select * from ShopCharInfo where SHUserId=@id and SDelect=1";
            SqlParameter[] ps =
            {
                new SqlParameter ("@id",uid)
            };
            DataTable dt = sqlHelp.getDatable(sql, ps);
            List<ShopCharModel> list = new List<ShopCharModel>();
            if (dt.Rows.Count > 0)
            {
                foreach(DataRow dr in dt.Rows)
                {
                    ShopCharModel scm = new ShopCharModel();
                    scm.MyThingId = dr[2].ToString();
                    scm.ChangeThingId = dr[1].ToString();
                    scm.UserId = dr[3].ToString();
                    list.Add(scm);
                }
            }
            return list;
        }
        #endregion
        #region 查询购物车未同意交换物品
        public List<ShopCharModel> selectShopCharbychar(string uid)
        {
            string sql = "select * from ShopCharInfo where SUserId=@id and SDelect=1";
            SqlParameter[] ps =
            {
                new SqlParameter ("@id",uid)
            };
            DataTable dt = sqlHelp.getDatable(sql, ps);
            List<ShopCharModel> list = new List<ShopCharModel>();
            if (dt.Rows.Count > 0)
            {
                foreach (DataRow dr in dt.Rows)
                {
                    ShopCharModel scm = new ShopCharModel();
                    scm.MyThingId = dr[2].ToString();
                    scm.ChangeThingId = dr[1].ToString();
                    scm.UserId = dr[3].ToString();
                    list.Add(scm);
                }
            }
            return list;
        }
        #endregion
        #region 该购物车以同意交换的物品
        public List<ShopCharModel> selectShopCharOver(string uid)
        {
            string sql = "select * from ShopCharInfo where SUserId=@id and SDelect=0";
            SqlParameter[] ps =
            {
                new SqlParameter ("@id",uid)
            };
            DataTable dt = sqlHelp.getDatable(sql, ps);
            List<ShopCharModel> list = new List<ShopCharModel>();
            if (dt.Rows.Count > 0)
            {
                foreach (DataRow dr in dt.Rows)
                {
                    ShopCharModel scm = new ShopCharModel();
                    scm.MyThingId = dr[1].ToString();
                    scm.ChangeThingId = dr[2].ToString();
                    scm.UserId = dr[3].ToString();
                    list.Add(scm);
                }
            }
            return list;
        }
        #endregion

        #region 查询购物车里我的被交换物品
        public List<string> selectShopCharMyThing(string uid)
        {
            string sql = "select distinct SHThingId from ShopCharInfo where SHUserId=@uid and SDelect=1";
            SqlParameter[] ps = { new SqlParameter("@uid", uid) };
            List<string> list = new List<string>();
            DataTable dt = sqlHelp.getDatable(sql, ps);
            if (dt.Rows.Count > 0)
            {
                foreach(DataRow dr in dt.Rows)
                {
                    string str = dr[0].ToString();
                    list.Add(str);
                }
            }
            return list;
        }
        public List<string> selectShopCharMyThingdelect(string uid)
        {
            string sql = "select distinct SHThingId from ShopCharInfo where SHUserId=@uid and SDelect=0";
            SqlParameter[] ps = { new SqlParameter("@uid", uid) };
            List<string> list = new List<string>();
            DataTable dt = sqlHelp.getDatable(sql, ps);
            if (dt.Rows.Count > 0)
            {
                foreach (DataRow dr in dt.Rows)
                {
                    string str = dr[0].ToString();
                    list.Add(str);
                }
            }
            return list;
        }
        #endregion

        #region 购物车里的物品完成交易
        public int updateShopChar(ShopCharModel s)
        {
            string sql = "update  ShopCharInfo set SDelect=0 where SThingId=@changeid and SHThingId=@myid";
            SqlParameter[] ps =
            {
                new SqlParameter ("@myid",s.MyThingId),
                new SqlParameter ("@changeid",s.ChangeThingId)
            };
            return sqlHelp.ExecuteNonQuery(sql, ps);
        }
        #endregion
        #region 其他没交换物品重新上架
        public int addOtherThing(string id)
        {
            string sql = "update ShopThingInfo set ThingDelect=1 where ThingId=@id";
            SqlParameter[] ps = { new SqlParameter("@id", id) };
            return sqlHelp.ExecuteNonQuery(sql, ps);
        }
        #endregion
        #region 查询其他没有被交换的物品
        public List<string> selectOtherThing(ShopCharModel s)
        {
            string sql = "select SThingId from ShopCharInfo where SthingId!=@changeid and SHThingId=@myid";
            SqlParameter[] ps =
            {
                new SqlParameter("@myid",s.MyThingId),
                new SqlParameter("@changeid",s.ChangeThingId)
            };
            DataTable dt = sqlHelp.getDatable(sql, ps);
            List<string> list = new List<string>();
            if (dt.Rows.Count > 0)
            {
                foreach(DataRow dr in dt.Rows)
                {
                    string str = dr[0].ToString();
                    list.Add(str);
                }
            }
            return list;
        }
        #endregion
        #region 删除其他交换记录
        public int deleteOtherThing(ShopCharModel s)
        {
            string sql = "delete from ShopCharInfo where SthingId!=@changeid and SHThingId=@myid";
            SqlParameter[] ps =
           {
                new SqlParameter("@myid",s.MyThingId),
                new SqlParameter("@changeid",s.ChangeThingId)
            };
            return sqlHelp.ExecuteNonQuery(sql, ps);
        }
        #endregion
    
    }
}
