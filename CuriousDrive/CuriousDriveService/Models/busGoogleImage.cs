using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace CuriousDriveService.Models
{
    public class Image
    {
        public string url { get; set; }
        public bool isDefault { get; set; }
    }

    public class busGoogleImage
    {
        public Image image { get; set; }
    }
}