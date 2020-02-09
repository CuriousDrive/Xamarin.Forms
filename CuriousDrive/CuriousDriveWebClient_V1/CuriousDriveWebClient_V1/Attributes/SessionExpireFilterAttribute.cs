using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.Filters;

namespace CuriousDriveWebClient.Attributes
{
    public class SessionExpireFilterAttribute : ActionFilterAttribute
    {
        public override void OnActionExecuting(ActionExecutingContext filterContext)
        {
            //HttpContext httpContext = HttpContext.;

            if ((filterContext.HttpContext.Session.GetInt32("UserId") ?? 0) == 0)
            {
                // check if a new session id was generated
                filterContext.Result = new RedirectResult("~/account/login");
                return;
            }

            base.OnActionExecuting(filterContext);
        }
    }
}