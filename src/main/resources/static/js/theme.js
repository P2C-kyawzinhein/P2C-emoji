const body = document.documentElement;
const icon = document.getElementById("darkIcon");

// 🔥 ページ読み込み時に前回の状態を反映
if (localStorage.getItem("theme") === "dark") {
    document.documentElement.classList.add("dark-mode");
    document.getElementById("darkIcon")?.classList.replace("bi-moon", "bi-sun");
}

// 🔘 ボタン押したら切り替え
document.getElementById("darkModeToggle")?.addEventListener("click", () => {

    body.classList.toggle("dark-mode");

    if (body.classList.contains("dark-mode")) {
        localStorage.setItem("theme", "dark");
        icon?.classList.replace("bi-moon", "bi-sun");
    } else {
        localStorage.setItem("theme", "light");
        icon?.classList.replace("bi-sun", "bi-moon");
    }
});
