using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Data;

namespace NerdDinner.Models
{
    public class DinnerRepository : NerdDinner.Models.IDinnerRepository
    {
        NerddinnerEntities db = new NerddinnerEntities();

        public IQueryable<Dinner> FindDinnersByText(string q)
        {
            return db.Dinners.Where(d => d.Title.Contains(q)
                   || d.Description.Contains(q) || d.C_HostedBy.Contains(q));
        }


        public IQueryable<Dinner> FindAllDinners()
        {
            return db.Dinners;
        }

        public IQueryable<Dinner> FindUpComingDinners()
        {
            return from dinner in FindAllDinners()
                   where dinner.EventDate >= DateTime.Now
                   orderby dinner.EventDate
                   select dinner;
        }
        public IQueryable<Dinner> FindByLocation(float latitude, float longitude)
        {
            var dinners=from dinner in FindUpComingDinners()
                        join i in NearestD
        }
        public void Add(Dinner dinner)
        {
            throw new NotImplementedException();
        }
       
        public void Delete(Dinner dinner)
        {
            throw new NotImplementedException();
        }
        public Dinner GetDinner(int id)
        {
            throw new NotImplementedException();
        }

        public void Save()
        {
            throw new NotImplementedException();
        }

        //Helper Methods
    }
}