using System.IO;

namespace Zadanie02
{
    public class MessageStorage
    {
        private readonly FileStorage store;
        private readonly Cache cache;
        private readonly Logger logger;

        public MessageStorage(DirectoryInfo workingDirectory)
        {
            store = new FileStorage(workingDirectory);
            cache = new Cache();
            logger = new Logger();
        }

        public virtual FileStorage Store
        {
            get { return this.store; }
        }

        public virtual Cache Cache
        {
            get { return this.cache; }
        }

        public virtual Logger Logger
        {
            get { return this.logger; }
        }
    }
}