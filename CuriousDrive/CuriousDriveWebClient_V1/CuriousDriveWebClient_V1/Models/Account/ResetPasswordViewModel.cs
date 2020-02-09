using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace CuriousDriveWebClient
{
    public class ResetPasswordViewModel
    {
        public int userId { get; set; }
        public string password { get; set; }
        public int retypePassword { get; set; }
    }
}
