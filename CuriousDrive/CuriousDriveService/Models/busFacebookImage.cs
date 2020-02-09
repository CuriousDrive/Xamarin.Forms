using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace CuriousDriveService.Models
{
    public class Data
    {
        public bool is_silhouette { get; set; }
        public string url { get; set; }
    }

    public class busFacebookImage
    {
        public Data data { get; set; }
    }
}