using Cwp.BLL.gym;
using Cwp.Model;
using Cwp.Model.gym;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;

namespace Cwp.GYM.Controllers
{
    public class gym_equipmentController : EntityController<gym_equipment, gym_equipmentBLL>
    {
        [HttpGet]
        public dataList<gym_equipmentAndImg> getOwinEquipmentAndImg(string pageIndex, string pageSize, string search = null, string paramList = null)
        {
            return new gym_equipmentBLL().GetDataListAndImg(pageIndex,pageSize,search,paramList);
        }
    }
}