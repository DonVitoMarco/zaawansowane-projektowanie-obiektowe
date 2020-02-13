using System;
using System.Collections.Generic;

namespace Zadanie04
{
    public class Cache
    {
        private readonly Dictionary<string, string> cache;

        public Cache()
        {
            cache = new Dictionary<string, string>();
        }

        public virtual void AddToCache(string path, string message)
        {
            cache.Add(path, message);
        }

        public virtual void WriteToCache(string path, string message)
        {
            cache[path] = message;
        }

        public virtual Boolean Contains(string path)
        {
            return cache.ContainsKey(path);
        }

        public virtual string GetMessageFromCache(string path)
        {
            return cache[path];
        }
    }
}