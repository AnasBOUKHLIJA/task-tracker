export type SiteConfig = typeof siteConfig;

export const siteConfig = {
	name: "Next.js + NextUI",
	description: "Make beautiful websites regardless of your design experience.",
	navItems: [
		{
			label: "Home",
			href: "/",
		},
		{
			label: "Projects",
			href: "/projects",
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
			label: "Projects",
			href: "/projects",
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
		github: "https://github.com/AnasBOUKHLIJA"
	},
	backend_url: "http://localhost:8080/task-tracker/api/v1",

};
