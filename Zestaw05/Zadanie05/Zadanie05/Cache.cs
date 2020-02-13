using System.Collections.Generic;

namespace Zadanie05
{
    public class Cache : ICacheStore
    {
        private readonly Dictionary<string, string> cache;

        public Cache()
        {
            cache = new Dictionary<string, string>();
        }

        public virtual bool AddOrUpdate(string id, string message)
        {
            cache[id] = message;
            return cache.ContainsKey(id);
        }

        public virtual string GetOrAdd(string id, string message)
        {
            if (!cache.ContainsKey(id))
            {
                cache[id] = message;
            }
            return cache[id];
        }
    }
}