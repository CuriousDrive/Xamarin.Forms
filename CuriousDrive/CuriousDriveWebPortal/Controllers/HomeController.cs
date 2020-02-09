using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace CuriousDriveWebPortal.Controllers
{
    public class HomeController : Controller
    {
        public ActionResult Index()
        {
            return View();
        }

        public ActionResult About()
        {
            ViewBag.Message = "Your application description page.";

            return View();
        }

        public ActionResult Contact()
        {
            ViewBag.Message = "Your contact page.";

            return View();
        }

        [HttpPost]
        public JsonResult SendBookADemoEmail(string astrEmailAddress)
        {
            //new AdminService().SendBookADemoEmail(astrEmailAddress);
            return null;
        }

        [HttpPost]
        public JsonResult SendContactUsEmail(string astrName, string astrEmailAddress, string astrSubject, string astrTelNumber, string astrComments)
        {
            //new AdminService().SendContactUsEmail(astrName, astrEmailAddress, astrSubject, astrTelNumber, astrComments);
            return null;
        }
    }
}