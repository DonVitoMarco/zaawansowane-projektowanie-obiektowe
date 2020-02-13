using System;
using System.Collections.Generic;

namespace Zadanie01
{
    public class Cache
    {
        private readonly Dictionary<string, string> cache;

        public Cache()
        {
            cache = new Dictionary<string, string>();
        }

        public void AddToCache(string path, string message)
        {
            cache.Add(path, message);
        }

        public void WriteToCache(string path, string message)
        {
            cache[path] = message;
        }

        public Boolean Contains(string path)
        {
            return cache.ContainsKey(path);
        }

        public string GetMessageFromCache(string path)
        {
            return cache[path];
        }
    }
}