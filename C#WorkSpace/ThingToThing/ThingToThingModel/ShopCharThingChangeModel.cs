using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ThingToThingModel
{
   public class ShopCharThingChangeModel
    {
        public ShopThingModel myshopThing { get; set; }
        public ShopThingModel changeshopThing { get; set; }
        public string myshopUrl { get; set; }
        public string changeshopUrl { get; set; }
    }
}
