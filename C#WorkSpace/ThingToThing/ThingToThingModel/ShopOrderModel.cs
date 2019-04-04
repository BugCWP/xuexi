using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ThingToThingModel
{
   public class ShopOrderModel
    {
        public ShopThingModel MyThing { get; set; }
        public List<ShopThingModel> ChangeThing { get; set; }
    }
}
