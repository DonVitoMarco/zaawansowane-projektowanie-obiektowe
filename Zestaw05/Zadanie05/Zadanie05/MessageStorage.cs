namespace Zadanie05
{
    public class MessageStorage
    {
        private readonly IStore store;
        private readonly ICacheStore cache;
        private readonly ILoggerStore logger;

        public MessageStorage(IStore storeImpl, ICacheStore cacheStore, ILoggerStore loggerStore)
        {
            store = storeImpl;
            cache = cacheStore;
            logger = loggerStore;
        }

        public virtual IStore Store
        {
            get { return this.store; }
        }

        public virtual ICacheStore Cache
        {
            get { return this.cache; }
        }

        public virtual ILoggerStore Logger
        {
            get { return this.logger; }
        }
    }
}