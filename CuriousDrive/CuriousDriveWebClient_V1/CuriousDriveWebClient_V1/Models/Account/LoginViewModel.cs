using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace CuriousDriveWebClient
{
    public class LoginViewModel
    {
        public string EmailAddress { get; set; }
        public string Password { get; set; }
        public IEnumerable<String> AllSchemeProvider { get; set; }
    }
}
