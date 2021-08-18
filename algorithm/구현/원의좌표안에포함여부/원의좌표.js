/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */

let x = [3, 4];
let y = [3, 5];
let r = [2, 3];
let v = [12, 83, 54, 35, 686, 337, 258, 95, 170, 831, 8, 15];

const solution = function () {
  const size = x.length;
  let tempL = 10000;
  let tempR = 0;
  let tempB = 10000;
  let tempT = 0;

  for (let i = 0; i < size; i++) {
    tempL = x[i] - r[i] < tempL ? x[i] - r[i] : tempL;
    tempR = x[i] + r[i] > tempR ? x[i] + r[i] : tempR;
    tempB = y[i] - r[i] < tempB ? y[i] - r[i] : tempB;
    tempT = y[i] + r[i] > tempT ? y[i] + r[i] : tempT;
  }
  let idx = 0;
  let pos = [];
  while (idx < v.length) {
    let tempX = v[idx++];
    let tempY = v[idx++];
    //l+x%(r-l)
    let makeX = tempL + (tempX % (tempR - tempL));
    //b+y%(t-b)
    let makeY = tempB + (tempY % (tempT - tempB));
    pos.push([makeX, makeY]);
  }

  let cnt = 0;
  for (let i = 0; i < pos.length; i++) {
    for (let j = 0; j < r.length; j++) {
      if (
        Math.pow(r[j], 2) >=
        Math.pow(x[j] - pos[i][0], 2) + Math.pow(y[j] - pos[i][1], 2)
      ) {
        cnt++;
        console.log(pos[i]);
        break;
      }
    }
  }
  console.log((cnt / pos.length) * (tempR - tempL) * (tempT - tempB));
};

solution();
