'use client'

import { ProjectItem } from "@/components/ProjectItem";
import { title } from "@/components/primitives";
import { Project } from "@/models/Project";
import { ProjectService } from "@/services/ProjectService";
import { useEffect, useState } from "react";

export default function ProjectsPage() {

	const [projects, setProjects] = useState<Project[]>([]);

	useEffect(() => {
		ProjectService.getAllProjects().then((response) => {
			setProjects(response);
		});
	}, []);

	return (
		<div>
			<h1 className={`${title()} py-5`}>Projects dashboard</h1>
			{projects.map((project) => (
				<ProjectItem key={project.id} project={project}></ProjectItem>
			))}
		</div>
	);
}
