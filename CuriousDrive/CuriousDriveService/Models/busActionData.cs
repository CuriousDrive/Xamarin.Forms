using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace CuriousDriveService.Models
{
    public class busActionData
    {
        //which post we are coming from and where we need to go after login - 
        public string istrRedirectActionName { get; set; }
        public string istrRedirectControllerName { get; set; }
        public int iintId { get; set; }

        //what data we need to carry before navigating to login page - 
        public string istrAction { get; set; }
        public int iintActionId { get; set; }
        public string istrActionData { get; set; }
    }
}