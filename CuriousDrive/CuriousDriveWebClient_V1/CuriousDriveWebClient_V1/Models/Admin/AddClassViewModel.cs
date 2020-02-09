using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using CuriousDriveWebAPI.CuriousDrive.Models;

namespace CuriousDriveWebClient
{
    public class AddClassViewModel
    {
        public string className { get; set; }
        public string description { get; set; }
        public List<ClassViewModel> classesViewModel { get; set; }
    }
}
