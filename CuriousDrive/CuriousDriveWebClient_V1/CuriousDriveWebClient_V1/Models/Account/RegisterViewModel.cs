using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace CuriousDriveWebClient
{
    public class RegisterViewModel
    {       
        public string emailAddress { get; set; }
        public string password { get; set; }
        public string confirmPassword { get; set; }
        public IEnumerable<String> AllSchemeProvider { get; set; }

    }
}
