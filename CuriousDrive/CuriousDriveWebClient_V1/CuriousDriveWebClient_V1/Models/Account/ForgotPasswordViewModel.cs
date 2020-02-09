using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace CuriousDriveWebClient
{
    public class ForgotPasswordViewModel
    {
        public string emailAddress { get; set; }
        public string plainOTP { get; set; }
        public string otp { get; set; }
        public string emailVerificationCode { get; set; }
    }
}
