using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using ThingToThingDAL;
using ThingToThingModel;
using ThingToThingCommon;

namespace ThingToThingBLL
{
   public class ShopCharBLL
    {
        ShopCharDAL scd = new ShopCharDAL();

        public bool ShopCharThingAdd(string myid,string changeid,string Userid,string HUserid)
        {
            if (scd.ShopCharThingAdd(myid, changeid, Userid,HUserid) > 0)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        public List<ShopCharModel> selectShopChar(string id)
        {
            return scd.selectShopChar(id);
        }
        public List<ShopCharModel> selectShopCharbychar(string id)
        {
            return scd.selectShopCharbychar(id);
        }
        public List<ShopCharModel> selectShopCharOver(string id)
        {
            return scd.selectShopCharOver(id);
        }
        public List<string> selectShopCharmyThing(string id)
        {
            return scd.selectShopCharMyThing(id);
        }
        public List<string> selectShopCharmyThingdelect(string id)
        {
            return scd.selectShopCharMyThingdelect(id);
        }
        public bool updateshopchar(ShopCharModel s)
        {
            if (scd.updateShopChar(s) > 0)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        public List<string> selectOtherThing(ShopCharModel s)
        {
            return scd.selectOtherThing(s);
        }
        public bool addOtherThing(string id)
        {
            if (scd.addOtherThing(id) > 0)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        public bool deleteOtherThing(ShopCharModel s)
        {
            if (scd.deleteOtherThing(s) > 0)
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
