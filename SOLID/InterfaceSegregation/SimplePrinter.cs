using System;

namespace SOLID.InterfaceSegregation
{
    public class SimplePrinter : IPrint {

        
        public void Print() {
            Console.WriteLine("Print pages");
        }
        
    }
}
