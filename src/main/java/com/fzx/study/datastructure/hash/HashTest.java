package com.fzx.study.datastructure.hash;

public class HashTest {
    public static void main(String[] args) throws Exception {
        IntSet4 intSet1 = new IntSet4(100000);
        for (int i = 0; i < 50; i++) {
            intSet1.Add(i);
        }

        for (int i = 0; i < 50; i++) {
            System.out.println(intSet1.Contains(i));
        }
        IntSet4 intSet41=new IntSet4(100000);;
        IntSet4 intSet4=intSet1;
        System.out.println(intSet1.hashCode());
        System.out.println(intSet4.hashCode());

        System.out.println(intSet41.hashCode());
    }
}

class IntSet1 {
    private Object[] _values = new Object[10];

    private int H(int value) {
        return value % 10;
    }

    public void Add(int item) {
        _values[H(item)] = item;
    }

    public void Remove(int item) {
        _values[H(item)] = null;
    }

    public boolean Contains(int item) {
        if (_values[H(item)] == null)
            return false;
        else
            return (int) _values[H(item)] == item;
    }
}
 class IntSet4
{
    private Object[] _values;
    private final int DELETED = -1;

    public IntSet4(int capacity)
    {
        int size = GetPrime(capacity);
        _values = new Object[size];
    }

    // 质数表
    private final int[] primes = {
        3, 7, 11, 17, 23, 29, 37, 47, 59, 71, 89, 107, 131, 163, 197, 239, 293, 353, 431, 521, 631, 761, 919,
        1103, 1327, 1597, 1931, 2333, 2801, 3371, 4049, 4861, 5839, 7013, 8419, 10103, 12143, 14591,
        17519, 21023, 25229, 30293, 36353, 43627, 52361, 62851, 75431, 90523, 108631, 130363, 156437,
        187751, 225307, 270371, 324449, 389357, 467237, 560689, 672827, 807403, 968897, 1162687, 1395263,
        1674319, 2009191, 2411033, 2893249, 3471899, 4166287, 4999559, 5999471, 7199369};

    // 判断 candidate 是否是质数
    private boolean IsPrime(int candidate)
    {
        if ((candidate & 1) != 0) // 是奇数
        {

            int limit = (int)Math.sqrt(candidate);
            for (int divisor = 3; divisor <= limit; divisor += 2) // divisor = 3、5、7...candidate的平方根
            {
                if ((candidate % divisor) == 0)
                    return false;
            }
            return true;
        }
        return (candidate == 2); // 除了2，其它偶是全都不是质数
    }
    // 如果 min 是质数，返回 min；否则返回比 min 稍大的那个质数
    private int GetPrime(int min)
    {
        // 从质数表中查找比 min 稍大的质数
        for (int i = 0; i < primes.length; i++)
        {
            int prime = primes[i];
            if (prime >= min) return prime;
        }

        // min 超过了质数表的范围时，探查 min 之后的每一个奇数，直到发现下一个质数
        for (int i = (min | 1); i < Integer.MAX_VALUE; i += 2)
        {
            if (IsPrime(i))
                return i;
        }
        return min;
    }

    int H1(int value)
    {
        return value % _values.length;
    }
    int H2(int value)
    {
        return 1 + (value % (_values.length - 1));
    }
    int DH(int value, int i)
    {
        return (H1(value) + i * H2(value)) % _values.length;
    }

    public void Add(int item) throws Exception {
        int i = 0; // 已经探查过的槽的数量
        do
        {
            int j = DH(item, i); // 想要探查的地址
            if (_values[j] == null || (int)_values[j] == DELETED)
            {
                _values[j] = item;
                return;
            }
            else
            {
                i += 1;
            }
        } while (i <= _values.length);
        throw new Exception("集合溢出");
    }
    public boolean Contains(int item)
    {
        int i = 0; // 已经探查过的槽的数量
        int j = 0; // 想要探查的地址
        do
        {
            j = DH(item, i);
            if (_values[j] == null)
                return false;

            if ((int)_values[j] == item)
                return true;
            else
                i += 1;
        } while (i <= _values.length);
        return false;
    }
    public void Remove(int item)
    {
        int i = 0; // 已经探查过的槽的数量
        int j = 0; // 想要探查的地址
        do
        {
            j = DH(item, i);
            if (_values[j] == null)
                return;

            if ((int)_values[j] == item)
            {
                _values[j] = DELETED;
                return;
            }
            else
            {
                i += 1;
            }
        } while (i <= _values.length);
    }
}