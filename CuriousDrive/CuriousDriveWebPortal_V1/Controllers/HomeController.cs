using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using CuriousDriveWebPortal_V1.Models;

namespace CuriousDriveWebPortal_V1.Controllers
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

        public IActionResult Privacy()
        {
            return View();
        }

        [ResponseCache(Duration = 0, Location = ResponseCacheLocation.None, NoStore = true)]
        public IActionResult Error()
        {
            return View(new ErrorViewModel { RequestId = Activity.Current?.Id ?? HttpContext.TraceIdentifier });
        }
    }
}
