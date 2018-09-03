using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace NerdDinner.Models
{
    public interface IDinnerRepository
    {
        IQueryable<Dinner> FindAllDinners();
        IQueryable<Dinner> FindByLocation(float latitude, float longitude);
        IQueryable<Dinner> FindUpComingDinners();
        IQueryable<Dinner> FindDinnersByText(string q);
        Dinner GetDinner(int id);
        void Add(Dinner dinner);
        void Delete(Dinner dinner);
        void Save();
    }
}
