//The prime factors of 13195 are 5, 7, 13 and 29.

//What is the largest prime factor of the number 600,851,475,143 ? = 6857
use std::time::Instant;

fn prime(to_factor:i64) -> bool {
	let mut count:i64 = 0;
	let mut isprime:bool = true;
	let mut i:i64 = 1;
	while i < to_factor {
		if to_factor % i == 0 {
			count += 1;
			if count > 1 {
				isprime = false;
				break;
			}
		}
		i += 2;
	}
	isprime
}


fn main() {
	let now = Instant::now();
	let mut to_factor: i64 = 600_851_475_143;
	let keep: i64 = to_factor;
	let mut i = 2;
	
	while i <= to_factor {
		if to_factor % i == 0 {
			if prime(i) {
				to_factor = to_factor / i;
			}
		}
		i += 1;
	}
	println!("elapsed time: {:?}", now.elapsed());
    println!("{} is the largest prime factor of {}", i-1, keep);
}
