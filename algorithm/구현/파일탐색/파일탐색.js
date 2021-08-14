/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function (nums, target) {
  console.log("hi");
  const codeOwnersMap = {
    scripts: ["배수진"],
    services: {
      "business-leadger": ["고찬군", "배수진"],
      "toss-card": ["채주민", "유재섭"],
      payments: {
        team: ["황인규", "노태균"],
        team2: ["나아감", "고뭇알"],
      },
    },
  };

  splitDir = "services/payments/team2".split("/");
  solution(codeOwnersMap, "services/payments/team2", "");
};

let answer = [];
function solution(codeOwnersMap, directory, searchDir) {
  for (let key in codeOwnersMap) {
    if (codeOwnersMap[key].constructor === Object && directory.includes(key)) {
      depth(codeOwnersMap[key], directory, key + "/");
    } else if (codeOwnersMap[key].constructor === Array && key === directory) {
      answer = codeOwnersMap[key];
      break;
    }
  }
  if (answer.length == 0) console.log("찾는 수가 없습니다.");
  else console.log(answer);
}
function depth(codeOwnersMap, directory, searchDir) {
  for (let key in codeOwnersMap) {
    if (codeOwnersMap[key].constructor === Object && directory.includes(key)) {
      depth(codeOwnersMap[key], directory, searchDir + key);
    } else if (
      codeOwnersMap[key].constructor === Array &&
      searchDir + "/" + key === directory
    ) {
      answer = codeOwnersMap[key];
      break;
    }
  }
}
