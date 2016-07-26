using Owin;
using Microsoft.Owin;

[assembly:OwinStartup(typeof(WebChat.Startup))]
namespace WebChat
{
    public class Startup
    {
        public void Configuration(IAppBuilder app)
        {
            app.MapSignalR();
        }
    }
}