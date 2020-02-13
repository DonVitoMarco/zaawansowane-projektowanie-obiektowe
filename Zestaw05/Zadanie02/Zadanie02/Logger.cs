using System;

namespace Zadanie02
{
    public class Logger
    {
        public virtual void LogMessage(string message, int type)
        {
            if (type == 0)
                Console.WriteLine("INFO: {0}.", message);
            else if (type == 1)
                Console.WriteLine("DEBUG: {0}.", message);
        }
    }
}