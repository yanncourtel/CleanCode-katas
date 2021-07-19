using System;

namespace SOLID.InterfaceSegregation
{
    public class SimplePrinter : Machine {

        
        public void Print() {
            Console.WriteLine("Print pages");
        }

        
        public void Fax() {
            throw new NotSupportedException("Can't fax");
        }

        
        public void Scan() {
            throw new NotSupportedException("Can't scan");
        }

        
        public void Photocopy() {
            throw new NotSupportedException("Can't photocopy");
        }

    }
}
