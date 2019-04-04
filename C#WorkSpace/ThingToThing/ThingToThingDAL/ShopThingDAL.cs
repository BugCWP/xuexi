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
   public class ShopThingDAL
    {
        #region 查询用户的物品
        public List<ShopThingModel> selectShopThing(string id,int pageIndex,int pageSize)
        {
            string sql = "select * from (select *,ROW_NUMBER() over(order by ShopId) as num from ShopThingInfo where UserId=@id and ThingDelect=1)s where s.num between @start and @end";
            int start;
            int end;
            start = (pageIndex - 1) * pageSize + 1;
            end = pageSize * pageIndex;
            SqlParameter[] ps =
            {
                new SqlParameter ("@id",id),
                new SqlParameter("@start",start),
                new SqlParameter("@end",end)
            };
            DataTable dt = sqlHelp.getDatable(sql,ps);
            List<ShopThingModel> list = new List<ShopThingModel>();
            if (dt.Rows.Count > 0)
            {
                foreach(DataRow dr in dt.Rows)
                {
                    ShopThingModel stm = new ShopThingModel();
                    stm.ThingId = dr[1].ToString();
                    stm.ThingName = dr[2].ToString();
                    stm.ThingType = dr[3].ToString();
                    stm.UserId = dr[4].ToString();
                    stm.ThingTime = dr[5].ToString();
                    stm.ThingIntroduction = dr[7].ToString();
                    list.Add(stm);
                }
            }
            return list;
        }
        #endregion

        #region 查询用户物品的数量
        public int selectShopThingCount(string id)
        {
            string sql = "select count(*) from ShopThingInfo where UserId=@id and ThingDelect=1";
            SqlParameter[] ps =
            {
                new SqlParameter ("@id",id),
            };
            int res = Convert.ToInt32(sqlHelp.ExecuteScalar(sql, ps));
            return res;
        }
        #endregion

        #region 查询物品的图片
        public List<string> selectThingimg(string id)
        {
            string sql = "select ImgUrl from ThingImgInfo where ThingId=@id";
            SqlParameter[] ps =
            {
                new SqlParameter ("@id",id)
            };
            DataTable dt = sqlHelp.getDatable(sql, ps);
            List<string> list = new List<string>();
            if (dt.Rows.Count > 0)
            {
                foreach(DataRow dr in dt.Rows)
                {
                    string url = dr[0].ToString();
                    list.Add(url);
                }
            }
            return list;
        }
        #endregion

        #region 查询物品的所有历史
        public List<ShopThingModel> selectShopThingLiShi(string id)
        {
            string sql = "select * from  ShopThingInfo where UserId=@id";
            SqlParameter[] ps =
            {
                new SqlParameter ("@id",id),
            };
            DataTable dt = sqlHelp.getDatable(sql, ps);
            List<ShopThingModel> list = new List<ShopThingModel>();
            if (dt.Rows.Count > 0)
            {
                foreach (DataRow dr in dt.Rows)
                {
                    ShopThingModel stm = new ShopThingModel();
                    stm.ThingId = dr[1].ToString();
                    stm.ThingName = dr[2].ToString();
                    stm.ThingType = dr[3].ToString();
                    stm.UserId = dr[4].ToString();
                    stm.ThingTime = dr[5].ToString();
                    stm.ThingDelect = dr[6].ToString();
                    list.Add(stm);
                }
            }
            return list;
        }
        #endregion

        #region 查询所有的物品
        public List<ShopThingModel> selectAllThing(int pageIndex, int pageSize)
        {
            string sql = "select * from (select *,ROW_NUMBER() over(order by ShopId) as num from ShopThingInfo where ThingDelect=1)s where s.num between @start and @end";
            int start;
            int end;
            start = (pageIndex - 1) * pageSize + 1;
            end = pageSize * pageIndex;
            SqlParameter[] ps =
            {
                new SqlParameter("@start",start),
                new SqlParameter("@end",end)
            };
            DataTable dt = sqlHelp.getDatable(sql, ps);
            List<ShopThingModel> list = new List<ShopThingModel>();
            if (dt.Rows.Count > 0)
            {
                foreach (DataRow dr in dt.Rows)
                {
                    ShopThingModel stm = new ShopThingModel();
                    stm.ThingId = dr[1].ToString();
                    stm.ThingName = dr[2].ToString();
                    stm.ThingType = dr[3].ToString();
                    stm.UserId = dr[4].ToString();
                    stm.ThingTime = dr[5].ToString();
                    stm.ThingIntroduction = dr[7].ToString();
                    list.Add(stm);
                }
            }
            return list;
        }
        #endregion

        #region 查询除了自己的所有物品
        public List<ShopThingModel> selectAllThing(int pageIndex, int pageSize,string UserId)
        {
            string sql = "select * from (select *,ROW_NUMBER() over(order by ShopId) as num from ShopThingInfo where ThingDelect=1 and UserId!=@id)s where s.num between @start and @end";
            int start;
            int end;
            start = (pageIndex - 1) * pageSize + 1;
            end = pageSize * pageIndex;
            SqlParameter[] ps =
            {
                new SqlParameter("@start",start),
                new SqlParameter("@end",end),
                new SqlParameter("@id",UserId)
            };
            DataTable dt = sqlHelp.getDatable(sql, ps);
            List<ShopThingModel> list = new List<ShopThingModel>();
            if (dt.Rows.Count > 0)
            {
                foreach (DataRow dr in dt.Rows)
                {
                    ShopThingModel stm = new ShopThingModel();
                    stm.ThingId = dr[1].ToString();
                    stm.ThingName = dr[2].ToString();
                    stm.ThingType = dr[3].ToString();
                    stm.UserId = dr[4].ToString();
                    stm.ThingTime = dr[5].ToString();
                    stm.ThingIntroduction = dr[7].ToString();
                    list.Add(stm);
                }
            }
            return list;
        }
        #endregion

        #region 查询所有物品的数量
        public int selectAllThingCount()
        {
            string sql = "select count(*) from ShopThingInfo where ThingDelect=1";
            SqlParameter[] ps =
            {
                
            };
            int res = Convert.ToInt32(sqlHelp.ExecuteScalar(sql, ps));
            return res;
        }
        #endregion
        #region 查询除了自己的所有物品数量
        public int selectAllThingCount(string id)
        {
            string sql = "select count(*) from ShopThingInfo where ThingDelect=1 and UserId!=@id";
            SqlParameter[] ps =
            {
                new SqlParameter("@id",id)
            };
            int res = Convert.ToInt32(sqlHelp.ExecuteScalar(sql, ps));
            return res;
        }
        #endregion

        #region 查询所有物品类型
        public List<string> SelectShopThingType()
        {
            string sql = "select TypeTitle from ThingTypeInfo where TypeDelect=1";
            DataTable dt = sqlHelp.getDatable(sql);
            List<string> list = new List<string>();
            if (dt.Rows.Count > 0)
            {   
                foreach(DataRow dr in dt.Rows)
                {
                    string type = dr[0].ToString();
                    list.Add(type);
                }
            }
            return list;
        }
        #endregion

        #region 添加商品
        public int AddShopThing(ShopThingModel s)
        {
            string sql = "insert into ShopThingInfo (ThingId,ThingName,ThingType,UserId,ThingDelect,ThingIntroduction) values(@Tid,@Tname,@Ttype,@Uid,1,@Tintroduction)";
            SqlParameter[] ps =
            {
                new SqlParameter ("@Tid",s.ThingId),
                new SqlParameter("@Tname",s.ThingName),
                new SqlParameter("@Ttype",s.ThingType),
                new SqlParameter("@Uid",s.UserId),
                new SqlParameter("@Tintroduction",s.ThingIntroduction)
            };
            return sqlHelp.ExecuteNonQuery(sql, ps);
        }
        #endregion

        #region 添加物品照片
        public int AddimgUrl(ShopImgUrl siu)
        {
            string sql = "insert into ThingImgInfo (ImgUrl,ThingId) values(@url,@id)";
            SqlParameter[] ps =
            {
                new SqlParameter ("@url",siu.ImgUrl),
                new SqlParameter("@id",siu.ThingId)
            };
            return sqlHelp.ExecuteNonQuery(sql, ps);
        }
        #endregion

        #region 删除用户商品
        public int DelectShopThing(string id)
        {
            string sql = "update ShopThingInfo set ThingDelect=0 where ThingId=@id";
            SqlParameter[] ps =
            {
                new SqlParameter("@id",id)
            };
            return sqlHelp.ExecuteNonQuery(sql, ps);

        }
        #endregion

        #region 查询物品所有的信息
        public ShopThingModel selectShopThinginformation(string id)
        {
            string sql = "select * from ShopThingInfo where ThingId=@id";
            SqlParameter[] ps = { new SqlParameter("@id", id) };
            DataTable dt = sqlHelp.getDatable(sql, ps);
            DataRow dr = dt.Rows[0];
            ShopThingModel sm = new ShopThingModel();
            sm.ThingName = dr[2].ToString();
            sm.ThingType = dr[3].ToString();
            sm.UserId = dr[4].ToString();
            sm.ThingTime = dr[5].ToString();
            sm.ThingDelect = dr[6].ToString();
            sm.ThingIntroduction = dr[7].ToString();
            return sm;
        }
        #endregion

        #region 删除照片链接
        public int delectThingImgUrl(string id,string url)
        {
            string sql = "delete from ThingImgInfo where ImgUrl=@url and ThingId=@id";
            SqlParameter[] ps =
            {
                new SqlParameter ("@id",id),
                new SqlParameter("@url",url)
            };
            return sqlHelp.ExecuteNonQuery(sql, ps);
        }
        #endregion

        #region 修改商品信息
        public int updateShopThing(ShopThingModel sm)
        {
            string sql = "update ShopThingInfo set ThingName=@name , ThingType=@type,ThingIntroduction=@introduction where ThingId=@id";
            SqlParameter[] ps =
            {
                new SqlParameter("@name",sm.ThingName),
                new SqlParameter("@type",sm.ThingType),
                new SqlParameter("@introduction",sm.ThingIntroduction),
                new SqlParameter("@id",sm.ThingId)
            };
            return sqlHelp.ExecuteNonQuery(sql, ps);
        }
        #endregion

        #region 查找物品评论
        public List<PingJiaModel> selectThingPingJia(string id)
        {
            string sql = "select * from PingJiaInfo where PThingId=@id";
            SqlParameter[] ps = { new SqlParameter("@id", id) };
            DataTable dt = sqlHelp.getDatable(sql,ps);
            List<PingJiaModel> list = new List<PingJiaModel>();
            if (dt.Rows.Count > 0)
            {
                foreach(DataRow dr in dt.Rows)
                {
                    PingJiaModel p = new PingJiaModel();
                    p.ThingId = dr[1].ToString();
                    p.UserId = dr[2].ToString();
                    p.PingJiatxt = dr[3].ToString();
                    p.PJTime = dr[4].ToString();
                    list.Add(p);
                }
            }
            return list;
        }
        #endregion

        #region 添加物品评论
        public int PingJiaAdd(PingJiaModel p)
        {
            string sql = "insert into PingJiaInfo (PThingId,PUserId,Ptxt) values(@tid,@uid,@txt)";
            SqlParameter[] ps =
            {
                new SqlParameter("@tid",p.ThingId),
                new SqlParameter("@uid",p.UserId),
                new SqlParameter("@txt",p.PingJiatxt)
            };
            return sqlHelp.ExecuteNonQuery(sql, ps);
        }
        #endregion
    }
}
