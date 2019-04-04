using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using ThingToThingModel;
using ThingToThingDAL;

namespace ThingToThingBLL
{
   public  class ShopThingBLL
    {
        ShopThingDAL std = new ShopThingDAL();
        public List<ShopThingModel> SelectShopThing(string id,int pageIndex,int pageSize)
        {
            List<ShopThingModel> liststm = std.selectShopThing(id,pageIndex,pageSize);
            return liststm;
        }
        public List<string> SelectThingImgUrl(string id)
        {
            List<string> list = std.selectThingimg(id);
            return list;
        }

        public string  selectShopThingcount(string id)
        {
            return std.selectShopThingCount(id).ToString();
        }
        public List<ShopThingModel> SelectShopThingLiShi(string id)
        {
            return std.selectShopThingLiShi(id);
        }

        public List<ShopThingModel> selectAllThing(int pageIndex, int pageSize)
        {
            return std.selectAllThing(pageIndex, pageSize);
        }
        public List<ShopThingModel> selectAllThing(int pageIndex, int pageSize,string id)
        {
            return std.selectAllThing(pageIndex, pageSize,id);
        }

        public int selectAllThingCount()
        {
            return std.selectAllThingCount();
        }
        public int selectAllThingCount(string id)
        {
            return std.selectAllThingCount();
        }
        public List<string> selectShopThingType()
        {
            return std.SelectShopThingType();
        }

        public bool AddShopThing(ShopThingModel s)
        {
            if (std.AddShopThing(s) > 0)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        public bool AddimgUrl(ShopImgUrl siu)
        {
            if (std.AddimgUrl(siu)>0)
            {
                return true;
            }
            else
            {
                return false;
            }
        }


        public bool DelectShopThing(string id)
        {
            if (std.DelectShopThing(id)>0)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        public ShopThingModel selectShopThingInformation(string id)
        {
            return std.selectShopThinginformation(id);
        }

        public bool delectThingImgUrl(string id,string url)
        {
            if (std.delectThingImgUrl(id, url) > 0)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        public bool updateShopThing(ShopThingModel sm)
        {
            if (std.updateShopThing(sm) > 0)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        public List<PingJiaModel> selectThingPingJia(string id)
        {
            return std.selectThingPingJia(id);
        }
        public bool PingJiaAdd(PingJiaModel p)
        {
            if (std.PingJiaAdd(p) > 0)
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
