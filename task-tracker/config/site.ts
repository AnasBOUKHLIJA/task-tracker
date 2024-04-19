export type SiteConfig = typeof siteConfig;

export const siteConfig = {
	name: "Task Tracker",
	description: "Task Tracker",
	navItems: [
		{
			label: "Home",
			href: "/",
		},
		{
			label: "Bug Tasks",
			href: "/bugTasks",
		},
		{
			label: "Feature Tasks",
			href: "/featureTasks",
		},
		{
			label: "Team",
			href: "/team",
		}
	],
	navMenuItems: [
		{
			label: "Home",
			href: "/",
		},
		{
			label: "Bug Tasks",
			href: "/bugTasks",
		},
		{
			label: "Feature Tasks",
			href: "/featureTasks",
		},
		{
			label: "Team",
			href: "/team",
		},
		{
			label: "Logout",
			href: "/logout",
		},
	],
	links: {
		github: "https://github.com/AnasBOUKHLIJA/task-tracker"
	},
	priorities: {
		Highest: {
			name: "Highest",
			icon: "/assets/highest.svg"
		},
		High: {
			name: "High",
			icon: "/assets/high.svg"
		},
		Medium: {
			name: "Medium",
			icon: "/assets/medium.svg"

		},
		Lowest: {
			name: "Lowest",
			icon: "/assets/lowest.svg"
		},
		Low: {
			name: "Low",
			icon: "/assets/low.svg"
		},
	},
	severities: {
		Critical: {
			name: "Critical",
			icon: "/assets/highest.svg"
		},
		Major: {
			name: "Major",
			icon: "/assets/high.svg"
		},
		Minor: {
			name: "Minor",
			icon: "/assets/medium.svg"

		}
	},
	status : {
		ToDo: {
			name: "To Do",
			color: "warning"
		},
		InProgress: {
			name: "In Progress",
			color: "success"
		},
		Done: {
			name: "Done",
			color: "primary"
		}
	},
	backend_url: "http://localhost:8080/task-tracker/api/v1",

};
