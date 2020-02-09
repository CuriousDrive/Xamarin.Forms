using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.Filters;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace CuriousDriveWebClient.Attributes
{
    public abstract class ModelStateTransfer : ActionFilterAttribute
    {
        protected static readonly string Key = typeof(ModelStateTransfer).FullName;
    }

    public class ExportModelStateAttribute : ModelStateTransfer
    {
        public override void OnActionExecuted(ActionExecutedContext filterContext)
        {
            if ((filterContext.Result is RedirectResult) || (filterContext.Result is RedirectToRouteResult))
            {
                //List<Message> llstMessages = (List<Message>)filterContext.Controller.ViewData[Constant.ValidationMessages];

                //if (llstMessages != null)
                //    filterContext.Controller.TempData[Key] = llstMessages;
            }

            base.OnActionExecuted(filterContext);
        }
    }

    public class ImportModelStateAttribute : ModelStateTransfer
    {
        public override void OnActionExecuted(ActionExecutedContext filterContext)
        {
            //List<Message> llstMessage = (List<Message>)filterContext.Controller.TempData[Key];

            ////Only Import if we are viewing
            //if (filterContext.Result is ViewResult)
            //{
            //    Base lBase = (Base)filterContext.Controller.ViewData.Model;

            //    if (lBase != null)
            //        lBase.ilstMessages = llstMessage;
            //}
            //else
            //{
            //    //Otherwise remove it.
            //    filterContext.Controller.TempData.Remove(Key);
            //}
            
            base.OnActionExecuted(filterContext);
        }
    }
}