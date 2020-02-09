using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Claims;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Authentication;
using Microsoft.AspNetCore.Authentication.Cookies;
using Microsoft.AspNetCore.Builder;
using Microsoft.AspNetCore.Hosting;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.HttpsPolicy;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.DependencyInjection;

namespace CuriousDriveWebClient_V1
{
    public class Startup
    {
        public Startup(IConfiguration configuration)
        {
            Configuration = configuration;
        }

        public IConfiguration Configuration { get; }

        // This method gets called by the runtime. Use this method to add services to the container.
        public void ConfigureServices(IServiceCollection services)
        {
            services.Configure<CookiePolicyOptions>(options =>
            {
                // This lambda determines whether user consent for non-essential cookies is needed for a given request.
                options.CheckConsentNeeded = context => true;
                options.MinimumSameSitePolicy = SameSiteMode.None;
            });

            services.AddDistributedMemoryCache();

            services.Configure<CookiePolicyOptions>(options =>
            {
                // This lambda determines whether user consent for non-essential cookies is needed for a given request.
                options.CheckConsentNeeded = context => true;
                options.MinimumSameSitePolicy = SameSiteMode.None;
            });

            services.AddAuthentication(options =>
            {
                options.DefaultChallengeScheme = CookieAuthenticationDefaults.AuthenticationScheme;
                options.DefaultSignInScheme = CookieAuthenticationDefaults.AuthenticationScheme;
                options.DefaultAuthenticateScheme = CookieAuthenticationDefaults.AuthenticationScheme;
            })
            .AddFacebook(facebookOptions =>
            {
                facebookOptions.AppId = "318295725262502"; //TODO: Fill with your data from facebook
                facebookOptions.AppSecret = "5e9f0dbc9e59b86a83145b599c1595f8"; //TODO: Fill with your data from facebook
                facebookOptions.Scope.Add("public_profile");
                facebookOptions.Scope.Add("email");
                facebookOptions.Fields.Add("name");
                facebookOptions.Fields.Add("email");
                facebookOptions.Fields.Add("first_name");
                facebookOptions.Fields.Add("last_name");

                facebookOptions.ClaimActions.MapJsonKey(ClaimTypes.NameIdentifier, "id");
                facebookOptions.ClaimActions.MapJsonSubKey("urn:facebook:age_range_min", "age_range", "min");
                facebookOptions.ClaimActions.MapJsonSubKey("urn:facebook:age_range_max", "age_range", "max");
                facebookOptions.ClaimActions.MapJsonKey(ClaimTypes.DateOfBirth, "birthday");
                facebookOptions.ClaimActions.MapJsonKey(ClaimTypes.Email, "email");
                facebookOptions.ClaimActions.MapJsonKey(ClaimTypes.Name, "name");
                facebookOptions.ClaimActions.MapJsonKey(ClaimTypes.GivenName, "first_name");
                facebookOptions.ClaimActions.MapJsonKey("urn:facebook:middle_name", "middle_name");
                facebookOptions.ClaimActions.MapJsonKey(ClaimTypes.Surname, "last_name");
                facebookOptions.ClaimActions.MapJsonKey(ClaimTypes.Gender, "gender");
                facebookOptions.ClaimActions.MapJsonKey("urn:facebook:link", "link");
                facebookOptions.ClaimActions.MapJsonSubKey("urn:facebook:location", "location", "name");
                facebookOptions.ClaimActions.MapJsonKey(ClaimTypes.Locality, "locale");
                facebookOptions.ClaimActions.MapJsonKey("urn:facebook:timezone", "timezone");

                facebookOptions.SaveTokens = true;
            })
            .AddGoogle(googleOptions =>
            {
                googleOptions.ClientId = "784590901798-qamcesgamks715sfi35c3jualmhfb2qm.apps.googleusercontent.com";
                googleOptions.ClientSecret = "88hn9SKsizO5Wt9VfENmWulL";
            })
            .AddCookie();

            services.AddSession(options =>
            {
                // Set a short timeout for easy testing.
                options.IdleTimeout = TimeSpan.FromMinutes(20);
                options.Cookie.HttpOnly = true;
                // Make the session cookie essential
                options.Cookie.IsEssential = true;
            });

            services.AddMvc().SetCompatibilityVersion(CompatibilityVersion.Version_2_1);

            services.AddRouting(options => options.LowercaseUrls = true);

        }

        // This method gets called by the runtime. Use this method to configure the HTTP request pipeline.
        public void Configure(IApplicationBuilder app, IHostingEnvironment env)
        {
            if (env.IsDevelopment())
            {
                app.UseDeveloperExceptionPage();
            }
            else
            {
                app.UseExceptionHandler("/Home/Error");
                app.UseHsts();
            }

            app.UseHttpsRedirection();
            app.UseStaticFiles();
            app.UseCookiePolicy();
            app.UseSession();
            app.UseAuthentication();

            app.UseMvc(routes =>
            {
                routes.MapRoute(
                    name: "default",
                    template: "{controller=Account}/{action=Login}/{id?}");
            });
        }
    }
}
